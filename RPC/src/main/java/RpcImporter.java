import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/** @Author: shuyizhi @Date: 2018-09-17 16:10 @Description: RPC客户端本地服务代理 */
public class RpcImporter<S> {
    public S importer(final Class<?> serviceClass, final InetSocketAddress address) {

        return (S)
                Proxy.newProxyInstance(
                        serviceClass.getClassLoader(),
                        new Class[] {serviceClass.getInterfaces()[0]},
                        (proxy, method, args) -> {
                            Socket socket = null;
                            ObjectOutputStream outputStream = null;
                            ObjectInputStream inputStream = null;
                            try {
                                socket = new Socket();
                                socket.connect(address);
                                outputStream = new ObjectOutputStream(socket.getOutputStream());
                                outputStream.writeUTF(serviceClass.getName());
                                outputStream.writeUTF(method.getName());
                                outputStream.writeObject(method.getParameterTypes());

                                inputStream = new ObjectInputStream(socket.getInputStream());
                                // return inputStream.readObject();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            } finally {
                                if (null != socket) {
                                    socket.close();
                                }
                                if (null != outputStream) {
                                    outputStream.close();
                                }
                                if (null != inputStream) {
                                    inputStream.close();
                                }
                            }
                            return inputStream.readObject();
                        });

        /* return (S)
        Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[] {serviceClass.getInterfaces()[0]},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Socket socket = null;
                        ObjectOutputStream output = null;
                        ObjectInputStream input = null;
                        try {
                            socket = new Socket();
                            socket.connect(address);
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);

                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        } catch (Exception ex) {

                        } finally {
                            if (null != socket) {
                                socket.close();
                            }
                            if (null != output) {
                                output.close();
                            }
                            if (null != input) {
                                input.close();
                            }
                        }
                        return null;
                    }
                });*/
    }
}
