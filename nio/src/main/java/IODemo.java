import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @Author: shuyizhi @Date: 2018-07-30 9:24 @Description: Java IO
 * 参考：http://www.cnblogs.com/aishangJava/p/6869801.html
 * https://www.yiibai.com/java_nio/java-nio-channels.html#article-start
 */
public class IODemo {
    /**
     * 根据指定的文件路径创建文件
     *
     * @param filePath
     * @return model
     */
    public static FileModel createFile(String filePath) {
        FileModel model = new FileModel();
        if (StringUtils.isEmpty(filePath)) {
            model.setCreate(false);
            try {
                throw new Exception("参数错误: filePath为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(filePath);
        try {
            model.setCreate(file.createNewFile());
            model.setFileName(file.getName());
            model.setFileParent(file.getParent());
            /** GB为单位 */
            model.setFileSize(file.getTotalSpace() * 1024 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

    /**
     * InputStream 统计指定路径文件的大小
     *
     * @param filePath
     */
    public static void countFileLength(String filePath) {
        int count = 0;
        InputStream streamReader = null;
        try {
            streamReader = new FileInputStream(new File(filePath));
            while (streamReader.read() != -1) {
                count++;
            }
            System.out.println("文件的长度为: " + count + " byte");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != streamReader) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * BufferedInputStream统计
     *
     * @param filePath
     */
    public static void countFileLengthByBuffer(String filePath) {
        int count = 0;
        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(filePath)));
            while (inputStream.read() != -1) {
                count++;
            }
            System.out.println("文件的长度为: " + count + " byte");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * DataInputStream 获取指定路径文件的长度
     *
     * @param filePath
     */
    public static void countFileLengthByDataInputStream(String filePath) {
        int count = 0;
        DataInputStream inputStream = null;
        try {
            inputStream = new DataInputStream(new FileInputStream(new File(filePath)));
            while (inputStream.read() != -1) {
                count++;
            }
            System.out.println("文件的长度为: " + count + " byte");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用InputStream复制文件
     *
     * @param sourceFile 源文件路径
     * @param destFile 目的文件路径
     */
    public static void copyFileByStream(String sourceFile, String destFile) {
        if (StringUtils.isEmpty(sourceFile) || StringUtils.isEmpty(destFile)) {
            return;
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 输入流读取文件
            inputStream = new FileInputStream(new File(sourceFile));
            // 输出流写入文件
            outputStream = new FileOutputStream(new File(destFile));
            // 创建缓冲区
            byte[] bytes = new byte[1024 * 10];
            while (inputStream.read() != -1) {
                inputStream.read(bytes);
                // System.out.println(new String(bytes));
                outputStream.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用Buffered缓冲流复制文件
     *
     * @param sourcePath 源文件路径
     * @param destPath 目的文件路径
     */
    public static void copyFileByBufferedStream(String sourcePath, String destPath) {
        if (StringUtils.isEmpty(sourcePath) || StringUtils.isEmpty(destPath)) {
            return;
        }
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(new File(sourcePath)));
            File destFile = new File(destPath);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            outputStream = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] bytes = new byte[1024 * 10];
            while (inputStream.read(bytes) != -1) {
                // System.out.println(new String(bytes));
                outputStream.write(bytes);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用DataStream 复制文件
     *
     * @param sourcePath 源文件路径
     * @param destPath 目的文件路径
     */
    public static void copyFileByDataStream(String sourcePath, String destPath) {
        if (StringUtils.isEmpty(sourcePath) || StringUtils.isEmpty(destPath)) {
            return;
        }
        DataInputStream inputStream = null;
        DataOutputStream output = null;
        try {
            inputStream = new DataInputStream(new FileInputStream(new File(sourcePath)));
            File destFile = new File(destPath);
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            output = new DataOutputStream(new FileOutputStream(destFile));
            byte[] bytes = new byte[1024 * 10];
            while (inputStream.read(bytes) != -1) {
                // System.out.println(new String(bytes));
                output.write(bytes);
                output.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 使用FileChannel方式复制文件
     *
     * @param sourcePath 源文件
     * @param destPath 目的文件
     */
    public static void copyFileByFileChannel(String sourcePath, String destPath) {
        if (StringUtils.isEmpty(sourcePath) || StringUtils.isEmpty(destPath)) {
            return;
        }
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inputStream = new FileInputStream(new File(sourcePath));
            outputStream = new FileOutputStream(new File(destPath));
            inChannel = inputStream.getChannel();
            outChannel = outputStream.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
            while (true) {
                // 清空缓冲区
                buffer.clear();
                // 从通道中读取数据到缓冲区
                int r = inChannel.read(buffer);
                // 判断是否有从通道读到数据
                if (r == -1) {
                    break;
                }
                // 将buffer指针指向头部
                buffer.flip();
                // 将缓冲区的数据写入通道
                outChannel.write(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inChannel) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != outChannel) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // region 读取文件

    /**
     * FileReader读取文件
     *
     * @param filePath
     */
    public static void readFileByFileReader(String filePath) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            char[] buf = new char[1024 * 10];
            FileReader reader = new FileReader(filePath);
            while (reader.read(buf) > 0) {
                stringBuffer.append(buf);
            }
            stringBuffer.toString();
            System.out.println(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BufferedReader读取文件
     *
     * @param filePath
     */
    public static void readFileByBuffered(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(filePath);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String str = null;
            int count = 0;
            while ((str = reader.readLine()) != null) {
                // 输出文件内容
                // System.out.println(str);
                count++;
            }
            System.out.println("总共输出: " + count + " 条");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                IOUtils.closeStream(inputStream, null);
            }
        }
    }

    /**
     * 使用ApacheCommonsIO按行读取文件
     *
     * @param filePath
     */
    public static void readFileByCommonsIO(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException("文件不存在");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            List<String> list = FileUtils.readLines(file, Charset.forName("UTF-8"));
            int count = 0;
            for (String str : list) {
                // System.out.println(str);
                count++;
            }
            System.out.println("总共输出: " + count + " 条");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO 按行读取文件
     *
     * @param filePath
     */
    public static void readFileByNIO(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException("文件不存在");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            List<String> list = Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
            int count = 0;
            for (String str : list) {
                // System.out.println(str);
                count++;
            }
            System.out.println("总共输出: " + count + " 条");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // endregion

    // region 写入文件

    /**
     * FileWriter写入文件
     *
     * @param filePath 写入的文件路径
     * @param content 写入的内容
     */
    public static void writeFileByFileWriter(String filePath, String content) {
        if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
            try {
                throw new Exception("参数错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(filePath), true);
            writer.write(content + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                IOUtils.closeWriter(writer);
            }
        }
    }

    /**
     * BufferedWriter写入文件
     *
     * @param filePath 文件路径
     * @param content 文件内容
     */
    public static void writeFileByBufferedWriter(String filePath, String content) {
        if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
            try {
                throw new Exception("参数错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = null;
        try {
            /** 采用追加的方式 */
            bufferedWriter = new BufferedWriter(new FileWriter(new File(filePath), true));
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedWriter) {
                IOUtils.closeWriter(bufferedWriter);
            }
        }
    }

    /**
     * 使用nio中的Files.write写入数据
     *
     * @param filePath 文件名称
     * @param list 写入内容集合
     */
    public static void writerFileByNIOFiles(String filePath, List<String> list) {
        if (StringUtils.isEmpty(filePath) || null == list || list.size() == 0) {
            try {
                throw new Exception("参数错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /** 判断文件是否存在，不存在，则创建 */
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.write(
                    Paths.get(filePath), list, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用ApacheCommonsIO写入文件(Apache Commons IO 方式写入文件)
     *
     * @param filePath
     * @param content
     */
    public static void writerFileByCommonsIO(String filePath, String content) {
        if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
            try {
                throw new Exception("参数错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            File file = new File(filePath);
            FileUtils.write(file, content, Charset.forName("UTF-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Apache CommonsIO writeStringToFile
     *
     * @param filePath
     * @param content
     */
    public static void writerFileByCommonsIOWriteStringToFile(String filePath, String content) {
        if (StringUtils.isEmpty(filePath) || StringUtils.isEmpty(content)) {
            try {
                throw new Exception("参数错误");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            File file = new File(filePath);
            FileUtils.writeStringToFile(file, content, Charset.forName("UTF-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // endregion
}
