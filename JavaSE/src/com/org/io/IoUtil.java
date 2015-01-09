package com.org.io;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/** 
 *@Author:jilongliang 
 *@Date:2013-8-11 
 *@version:1.0 
 *@Email:jilongliang@sina.com 
 *=============================================================================================================== 
 *实际上字节流在操作时本身不会用到缓冲区（内存），是文件本身直接操作的，而字符流在操作时使用了缓冲区，通过缓冲区再操作文件。 
 * 
 *字符流和字节流是根据处理数据的不同来区分的。字节流按照8位传输，字符流按照16位传输 
 *由于字符流使用Unicode字符集，支持多国文字，因此若流要跨越多种平台传输，应使用字符流。 
 *=============================================================================================================== 
 *char型是字符型,占2个字节,默认数值'\u0000',取值范围'\u0000'~'\uffff' 
 *byte是字节型,占1个字节,默认数值0,取值范围-128～127 
 *boolean 无符号 8  位  
 *byte  无符号,8  位  
 *char  无符号,16 位 
 *short 有符号,16 位 
 *int \ 有符号,32 位 
 *long 有符号,64 位  
 *float  32 位  
 *double  64 位 
 *=============================================================================================================== 
 *字节流输出--->>程序-->>字节流---->文件(直接操作文件) 
 * 
 *字符流输出--->>程序-->>字符流---->>缓存--->>文件(数据线放在缓存,之后再从缓存写入文件) 
 * 
 *===============================================================================================================
 *@Description:字节流 
 *@InputStream 
 *    FileInputStream, FilterInputStream,BufferedInputStream, CheckedInputStream, CipherInputStream, 
 *    DataInputStream, DeflaterInputStream, DigestInputStream, InflaterInputStream, LineNumberInputStream, 
 *    ProgressMonitorInputStream, PushbackInputStream ,AudioInputStream, ByteArrayInputStream, FileInputStream, 
 *    ObjectInputStream, PipedInputStream, SequenceInputStream, StringBufferInputStream  
 *=============================================================================================================== 
 *@OutputStream 
 *    FileOutputStream, FilterOutputStream,BufferedOutputStream, CheckedOutputStream, CipherOutputStream, 
 *    DataOutputStream, DeflaterOutputStream, DigestOutputStream, InflaterOutputStream, LineNumberOutputStream, 
 *    ProgressMonitorOutputStream, PushbackOutputStream ,AudioOutputStream, ByteArrayOutputStream, FileOutputStream, 
 *    ObjectOutputStream, PipedOutputStream, SequenceOutputStream, StringBufferOutputStream  
 * 
 *=============================================================================================================== 
 * 
 *@Description字符流 
 *@Writer 
 *   BufferedWriter, CharArrayWriter, FilterWriter, OutputStreamWriter, PipedWriter, PrintWriter, StringWriter  
 *=============================================================================================================== 
 *@Reader 
 * 
 *BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader  
 *------------------------------------------------------------------------------------------------------------------ 
 */  
@SuppressWarnings("all")
public class IoUtil {
	private static List<File> fs = new ArrayList<File>(0);
	private static String content = "", line = System.getProperty("line.separator");// 换行相当于\n
	private static List fileList = new ArrayList();
	private static File tempFile = null;
	private static final long KB = 1024;// KB
	private static final long MB = KB * KB;// MB
	private static final long GB = KB * MB;// GB
	private static final int byt = 2048;
	private static File f = new File("");
	private static BASE64Encoder encoder = new BASE64Encoder();// 加密
	private static BASE64Decoder decoder = new BASE64Decoder();// 解密
	private static String webRootPath;
	private static String rootClassPath;

	
	/**
	 * 读文件流
	 * @param formPath从哪里读取的文件路径
	 * @return
	 */
	public static Map<String, String> readConfig(String formPath) {
		String content = "";
		Map<String, String> map = new HashMap<String, String>();
		FileReader read = null;
		BufferedReader reader = null;
		try {
			read = new FileReader(new File(formPath));
			reader = new BufferedReader(read);
			content = reader.readLine();
			while (content != null) {
				String val[] = content.split("=");
				if (val.length > 0) {
					String key = val[0];// ,分开
					map.put(key, val[1]);
				}
				content = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null||read!=null)
					reader.close();	read.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	 
	/**
	 * 读文件流
	 * 
	 * @param formPath从哪里读取的文件路径
	 * @return
	 */
	public static String reader(String formPath) {
		FileReader read = null;
		BufferedReader reader = null;
		try {
			read = new FileReader(new File(formPath));
			reader = new BufferedReader(read);
			StringBuffer buffer = new StringBuffer("");
			content = reader.readLine();
			while (content != null) {
				buffer.append(content).append(line);
				content = reader.readLine();
			}
			return content = buffer.toString();// 返回
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (read != null)
					read.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";// 没值就返回空
	}

	 

	/**
	 * 写文件 BufferedWriter BufferedReader
	 * 
	 * @param formPath
	 * @param toPath
	 */
	public static boolean writer(String formPath, String toPath) {
		Reader reader = null;
		Writer writer = null;
		boolean flag = true;
		BufferedWriter buffWriter = null;
		BufferedReader buffReader = null;
		try {
			reader = new FileReader(new File(formPath));
			writer = new FileWriter(new File(toPath));// writer不能关闭

			buffWriter = new BufferedWriter(writer);// 这个写完可以关闭
			buffReader = new BufferedReader(reader);

			content = buffReader.readLine();
			while (content != null) {
				buffWriter.write(line + content);
				content = buffReader.readLine();
				buffWriter.flush();// 只要用到缓冲区就flush//其实关闭了缓冲区,就是关闭缓冲区中流的对象.
									// //写一次flush是为了防止停电就挂了~
			}
			reader.close();
			buffReader.close();
			buffWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return flag;
	}
	 
	/**
	 * 文件处理 Writer OutputStreamWriter
	 * 
	 * @param content
	 *            OutputStreamWriter
	 * @param toPath写到那个路径下
	 * @return
	 */
	public static boolean Writer(String content, String toPath) {
		boolean flag = true;
		try {
			Writer out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(toPath), "utf-8"));// 设置编码
			out.write(line + content);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return flag;
	}

	/**
	 * 处理文件大小
	 */
	public static String fileSize(long file) {
		if (file <= 0) {
			return "";
		} else if (file < MB) {
			BigDecimal b = new BigDecimal((double) file / KB);
			return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "K";
		} else if (file < GB) {
			BigDecimal b = new BigDecimal((double) file / MB);
			return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M";
		} else {
			BigDecimal b = new BigDecimal((double) file / GB);
			return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "G";
		}
	}

	/**
	 * 删除目录下的所有子目录和文件
	 * 
	 * @param filepath
	 * @throws IOException
	 */
	protected static void deleteDirs(String filepath) throws IOException {
		File f = new File(filepath);// 定义文件路径
		if (f.exists()) {// 判断是否存在
			if (f.isDirectory()) {// 判断是文件还是目录
				if (f.listFiles().length == 0) {// 若目录下没有文件则直接删除
					f.delete();// 删除目录
				} else {// 若有则把文件放进数组，并判断是否有下级目录
					File delFile[] = f.listFiles();
					int i = f.listFiles().length;
					for (int j = 0; j < i; j++) {
						if (delFile[j].isDirectory()) {
							deleteDirs(delFile[j].getAbsolutePath());// 递归调用delDirs方法并取得子目录路径
						} else {
							delFile[j].delete();// 删除文件
						}
					}
					f.delete();// 删除目录
				}
			} else {
				f.delete();// 删除文件
			}
		}
	}

	/**
	 * 直接过滤图片所有格式的 重命名文件里面的名称
	 * 
	 * @param fileDir
	 * @param sequenceCode
	 */
	public static void renameFile(File fileDir, String sequenceCode) {
		File[] files = fileDir.listFiles();
		for (int k = 0; k < files.length; k++) {
			StringBuffer sb = new StringBuffer(sequenceCode);
			if (files[k].isDirectory()) {
				renameFile(files[k], sequenceCode);
			} else {
				if (k < 10)
					sb.append("_000").append(k);
				else if (k >= 10 && k < 100)
					sb.append("_00").append(k);
				else if (k < 1000 && k >= 100)
					sb.append("_0").append(k);
				else
					sb.append("_").append(k);
				final int index = files[k].getName().lastIndexOf(".") + 1;
				final String fileType = files[k].getName().substring(index);
				sb.append(".").append(fileType);
				final String name = sb.toString();
				final File dirFile = new File(fileDir, name);
				System.out.println("Rename File Path:" + files[k].getAbsolutePath());
				files[k].renameTo(dirFile);
			}
		}
	}

	/**
	 * 读取文件里面的所有文件
	 * 
	 * @param filePath
	 */
	public static void readFileList(String filePath) {
		File srcFile = new File(filePath);
		boolean flag = srcFile.exists();
		/**
		 * @flag判断文件是否存在
		 * @isDirectory测试此抽象路径名表示的文件是否是一个目录
		 * @canWrite测试应用程序是否可以读取此抽象路径名表示的文件
		 */
		if (!flag || !srcFile.isDirectory() || !srcFile.canRead()) {
			try {
				srcFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			File[] file = srcFile.listFiles();
			for (int i = 0; i < file.length; i++) {
				System.out.println(file[i].getAbsolutePath());
			}
		}
	}

	/**
	 * 以数组形式列出所有文件包括子类的文件
	 * 
	 * @param path
	 */
	public static List findFiles(String path) {
		try {
			File file = new File(path);
			File[] files = file.listFiles();
			String[] filenames = file.list();
			if (filenames == null)
				return fileList;
			for (int i = 0; i < filenames.length; i++) {
				if (files[i].isFile()) {
					fileList.add(files[i].getPath());
				} else if (files[i].isDirectory()) {
					findFiles(files[i].getPath());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

	/**
	 * 压缩文件
	 * 
	 * @param path压缩文件的路径
	 * @param toDir指定压缩文件到那个目录磁盘下
	 */
	public static void compressionZip(String path, String toDir) {
		File f = new File(path);
		try {
			InputStream fis = new FileInputStream(f);
			InputStream bis = new BufferedInputStream(fis);
			byte[] buf = new byte[1024 * 1024];
			int index = f.getName().lastIndexOf("\\") + 1;
			String fileName = f.getName().substring(index);
			if (fileName.matches(".*\\.(?i)gif")) { // 匹配gif格式文件
				fileName = fileName.replaceAll(".gif", "");
			} else if (fileName.matches(".*\\.(?i)java")) {// 匹配.java文件
				fileName = fileName.replaceAll(".java", "");
			}
			int len;
			OutputStream fos = new FileOutputStream(toDir + fileName + ".zip");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ZipOutputStream zos = new ZipOutputStream(bos);// 压缩包
			ZipEntry ze = new ZipEntry(f.getName());// 这是压缩包名里的文件名
			zos.putNextEntry(ze);// 写入新的 ZIP 文件条目并将流定位到条目数据的开始处
			while ((len = bis.read(buf)) != -1) {
				zos.write(buf, 0, len);
				zos.flush();
			}
			bis.close();
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解压zip文件
	 * 
	 * @param path解压文件路径
	 * @param flag标识
	 */
	public static void decompressZip(String path, boolean flag) {
		int count = -1;
		int index = -1;
		String savePath = "";
		savePath = path.substring(0, path.lastIndexOf("\\")) + "\\";
		try {
			BufferedOutputStream bos = null;
			ZipEntry entry = null;
			InputStream fis = new FileInputStream(path);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));
			while ((entry = zis.getNextEntry()) != null) {
				byte data[] = new byte[byt];
				String temp = entry.getName();
				flag = fileFilter(temp);
				if (!flag)
					continue;
				index = temp.lastIndexOf("/");
				if (index > -1)
					temp = temp.substring(index + 1);
				temp = savePath + temp;
				File f = new File(temp);
				if (!f.exists()) {// 不存在就创建一个新的文件
					f.createNewFile();
					// f.mkdirs();
				}
				OutputStream fos = new FileOutputStream(f);
				bos = new BufferedOutputStream(fos, byt);
				while ((count = zis.read(data, 0, byt)) != -1) {
					bos.write(data, 0, count);
				}
				bos.flush();// flush缓冲区
				fos.flush();
				bos.close();
				fos.close();
				fis.close();

			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param zip压缩文件文件路径
	 * @param zipName压缩文件里面的文件名称
	 * @param srcFiles多文件
	 * @throws IOException
	 */
	public static void ZipFiles(File zip, String zipName, File... srcFiles)
			throws IOException {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip));
		ZipFiles(out, zipName, srcFiles);
		out.close();
		System.out.println("*****************压缩完毕*******************");
	}

	/**
	 * 压缩文件-File
	 * 
	 * @param zipFile
	 *            zip文件
	 * @param srcFiles
	 *            被压缩源文件
	 * @author isea533
	 */
	public static void ZipFiles(ZipOutputStream zis, String path,
			File... srcFiles) {
		path = path.replaceAll("\\*", "/");
		if (!path.endsWith("/")) {
			path += "/";
		}
		byte[] buf = new byte[1024];
		try {
			for (int i = 0; i < srcFiles.length; i++) {
				if (srcFiles[i].isDirectory()) {
					File[] files = srcFiles[i].listFiles();
					String srcPath = srcFiles[i].getName();
					srcPath = srcPath.replaceAll("\\*", "/");
					if (!srcPath.endsWith("/")) {
						srcPath += "/";
					}
					zis.putNextEntry(new ZipEntry(path + srcPath));
					ZipFiles(zis, path + srcPath, files);
				} else {
					FileInputStream in = new FileInputStream(srcFiles[i]);
					System.out.println(path + srcFiles[i].getName());
					zis
							.putNextEntry(new ZipEntry(path
									+ srcFiles[i].getName()));
					int len;
					while ((len = in.read(buf)) > 0) {
						zis.write(buf, 0, len);
					}
					zis.closeEntry();
					in.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param zipPath
	 * @param descDir
	 * @throws IOException
	 */
	public static void unZipFiles(String zipPath, String descDir)
			throws IOException {
		unZipFiles(new File(zipPath), descDir);
	}

	/**
	 * 解压文件到指定目录
	 * 
	 * @param zipFile
	 * @param descDir
	 * @author isea533
	 */
	public static void unZipFiles(File zipFile, String descDir)
			throws IOException {
		File pathFile = new File(descDir);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		ZipFile zip = new ZipFile(zipFile);
		for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String zipEntryName = entry.getName();
			InputStream in = zip.getInputStream(entry);
			String outPath = (descDir + zipEntryName).replaceAll("\\*", "/");
			// 判断路径是否存在,不存在则创建文件路径
			File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
			if (!file.exists()) {
				file.mkdirs();
			}
			// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
			if (new File(outPath).isDirectory()) {
				continue;
			}
			// 输出文件路径信息
			System.out.println(outPath);

			OutputStream out = new FileOutputStream(outPath);
			byte[] buf1 = new byte[1024];
			int len;
			while ((len = in.read(buf1)) > 0) {
				out.write(buf1, 0, len);
			}
			in.close();
			out.close();
		}
		System.out.println("******************解压完毕********************");
	}

	/**
	 * 以数组形式存放图片,只拿jpg格式的
	 * 
	 * @param dirName
	 * @return
	 */
	public static List readDirFiles(String dirName) {// dirName目录全路径
		try {
			File file = new File(dirName);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File tempFile = files[i];
				if (tempFile.isDirectory()) {
					String path = tempFile.getPath();
					List list = readDirFiles(path);// 递归
					for (int j = 0; j < list.size(); j++) {
						fileList.add(list.get(j));
					}
				} else {
					String fileName = tempFile.getName();
					if (!tempFile.isFile()) {
						continue;
					}
					// 判断是jpg格式的就添加进去
					if (files[i].getName().endsWith(".gif")) {
						fileList.add(tempFile);
					}
				}
				if (i == (files.length - 1)) {
					return fileList;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

	/**
	 * 创建文件并且拷贝文件
	 * 
	 * @param dirFrom从那个文件里面拷贝
	 * @param dirTo拷贝到那个文件里面
	 */
	public static void copyFiles(File dirFrom, File dirTo) {
		File[] files = dirFrom.listFiles();
		for (File f : files) {
			String tempFrom = f.getAbsolutePath();
			String tempTo = tempFrom.replace(dirFrom.getAbsolutePath(), dirTo
					.getAbsolutePath()); // 后面的路径 替换前面的路径名
			if (f.isDirectory()) {
				tempFile = new File(tempTo);
				if (!tempFile.exists()) {
					tempFile.mkdirs();
				} else {
					copyFiles(dirFrom, dirTo);
				}
			} else {
				System.out.println("源文件:" + f.getAbsolutePath());
				int index = tempTo.lastIndexOf("\\");// 找到"/"所在的位置
				String mkdirPath = tempTo.substring(0, index);
				tempFile = new File(mkdirPath);
				if (!tempFile.exists()) {
					tempFile.mkdirs();
				} else {
					System.out.println("目标点:" + tempTo);
					readFiles(tempFrom, tempTo);
				}
			}
		}
	}

	/**
	 * 
	 * @param from从那个路径
	 * @param to到那个路径
	 */
	public static void readFiles(String from, String to) {
		try {
			InputStream in = new FileInputStream(from);
			OutputStream out = new FileOutputStream(to);
			byte[] buff = new byte[1024 * 1024];
			int len = 0;
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * xml格式化
	 * 
	 * @param document
	 * @param filePath
	 * @return
	 */
	 

	/**
	 * 过滤器
	 */
	private static FileFilter fileFilter = new FileFilter() {
		public boolean accept(File fileName) {
			String f = fileName.getName();
			if (f.endsWith(".png") || f.endsWith(".gif")) {
				return true;
			}
			return false;
		}
	};

	/**
	 * 文件过滤
	 * 
	 * @param filName
	 * @return
	 */
	public static boolean fileFilter(String filName) {
		if (filName.endsWith(".jpg") || filName.endsWith(".gif")
				|| filName.endsWith(".bmp") || filName.endsWith(".png")) {
			return false;
		} else {
			return true;
		}
	}

	/***
	 * ==============================================路径的封装begin================
	 * 获取当前工程路径
	 * 
	 * @return
	 */
	public static String getSysPath() {
		// String path =
		// Thread.currentThread().getContextClassLoader().getResource("").toString();
		String path = Thread.currentThread().getContextClassLoader()
				.getResource(".").toString();
		String temp = path.replaceFirst("file:/", "").replaceFirst(
				"WEB-INF/classes/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	/**
	 * Thread.currentThread().getContextClassLoader().getResource("")
	 * 的getResource里面空串或者点或者是/输出的路径是一致 "" D:\Eclipse3.7\JTool\build\classes\ .
	 * D:\Eclipse3.7\JTool\build\classes\ -/ D:\Eclipse3.7\JTool\build\classes\
	 * 
	 * @return
	 */
	public static String getClassPath() {
		// String path =
		// Thread.currentThread().getContextClassLoader().getResource("").toString();
		// String path
		// =Thread.currentThread().getContextClassLoader().getResource(".").toString();
		String path = Thread.currentThread().getContextClassLoader()
				.getResource(".").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	/**
	 * getClassLoader().getResource()方法参数空串和点都是输出相同的路径唯有 /是报空指针 ""
	 * D:\Eclipse3.7\JTool\build\classes\ . D:\Eclipse3.7\JTool\build\classes\
	 * -/ 报空指针
	 * 
	 * @return
	 */
	private String getClassesAbsolutePath() {
		// 得到的是 项目的绝对路径
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		// String
		// path=this.getClass().getClassLoader().getResource(".").getPath();
		// String
		// path=this.getClass().getClassLoader().getResource("/").getPath();//报空指针
		String temp = path.replaceFirst("/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	/**
	 *得到的是当前类 文件的URI目录,不包括自己
	 * ""D:\Eclipse3.7\JTool\build\classes\javax\org\path\ .
	 * D:\Eclipse3.7\JTool\build\classes\javax\org\path\ - /
	 * D:\Eclipse3.7\JTool\build\classes\
	 * 
	 * @return
	 */
	private String getCurrentClassPath() {
		// String path=this.getClass().getResource("").getPath();
		// String path=this.getClass().getResource(".").getPath();
		String path = this.getClass().getResource("/").getPath();
		String temp = path.replaceFirst("/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	public static String getPath(Class clazz) {
		String path = clazz.getResource("").getPath();
		return new File(path).getAbsolutePath();
	}

	public static String getPath(Object object) {
		String path = object.getClass().getResource("").getPath();
		return new File(path).getAbsolutePath();
	}

	public static String getRootClassPath() {
		if (rootClassPath == null) {
			try {
				String path = IoUtil.class.getClassLoader().getResource("").toURI().getPath();
				rootClassPath = new File(path).getAbsolutePath();
			} catch (Exception e) {
				String path = IoUtil.class.getClassLoader().getResource("").getPath();
				rootClassPath = new File(path).getAbsolutePath();
			}
		}
		return rootClassPath;
	}

	public static String getPackagePath(Object object) {
		Package p = object.getClass().getPackage();
		return p != null ? p.getName().replaceAll("\\.", "/") : "";
	}

	public static File getFileFromJar(String file) {
		throw new RuntimeException("Not finish. Do not use this method.");
	}

	public static String getWebRootPath() {
		if (webRootPath == null)
			webRootPath = detectWebRootPath();
		return webRootPath;
	}

	public static void setWebRootPath(String webRootPath) {
		if (webRootPath == null)
			return;

		if (webRootPath.endsWith(File.separator))
			webRootPath = webRootPath.substring(0, webRootPath.length() - 1);
		IoUtil.webRootPath = webRootPath;
	}

	private static String detectWebRootPath() {
		try {
			String path = IoUtil.class.getResource("/").toURI().getPath();
			return new File(path).getParentFile().getParentFile()
					.getCanonicalPath();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * =================================加密文件=====begin======================
	 * @param f
	 * @param path
	 */
	private static String encryptFile(File f, String path) {
		InputStream in = null;
		OutputStream out = null;
		String key = "";
		try {
			f = new File(path);
			in = new FileInputStream(f);
			out = new ByteArrayOutputStream();
			// System.out.println(f.getAbsolutePath());
			// System.out.println(f.length());
			encoder.encodeBuffer(in, out);
			key = out.toString();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 *解密 
	 * 
	 * @param f
	 * @param path
	 */
	private static String decryptFile(File f, String path) {
		InputStream in = null;
		OutputStream out = null;
		String key = "";
		try {
			f = new File(path);
			in = new FileInputStream(f);
			out = new ByteArrayOutputStream();
			decoder.decodeBuffer(in, out);
			key = out.toString();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String inputStr) {
		String value = "";
		try {
			byte[] key = inputStr.getBytes();
			value = encoder.encodeBuffer(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64(String outputStr) {
		String value = "";
		try {
			byte[] key = decoder.decodeBuffer(outputStr);
			value = new String(key);
		} catch (Exception e) {
		}
		return value;
	}
	/**
	 * 递归文件
	 * 
	 * @param file
	 * @return
	 */
	public static List<File> getFiles(File dir) {
		if (dir == null) {
			return null;
		}
		if (!dir.isDirectory()) {
			return null;
		}
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				fs.add(file);
			} else if (file.isDirectory()) {
				getFiles(file); // 如果遇到目录则通过递归调用继续统计
			}
		}
		return fs;
	}
	/**
	 * ================================end================================
	 */
	public static void main(String[] args) throws Exception {

		String path1 = "D:/data";
		List<File>  files=getFiles(new File(path1));
		for(File f:files){
			System.out.println(f.getCanonicalPath());
		}
		/**
		 * 压缩文件
		 */
		/*
		 * File[] files = new File[]{new File("d:/t/a.txt"),new
		 * File("d:/t/a.xls")}; File zip = new File("d:/t/压缩.zip");
		 * ZipFiles(zip,"ZipFiles",files);
		 *//**
		 * 解压文件
		 */
		/*
		 * File zipFile = new File("d:/t/压缩.zip"); String path = "d:/";
		 * //unZipFiles(zipFile, path);
		 */

		// String separator=f.separator;//与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串
//		String path = "D:/test/a.txt";
//		String s = reader(path);
//		System.out.println(s);

	}

}
