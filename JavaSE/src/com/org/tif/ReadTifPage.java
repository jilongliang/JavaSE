package com.org.tif;

import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.IOException;

import javax.media.jai.JAI;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.TIFFEncodeParam;

/**
 * 读取tif图片的一张.tif有几页
 *@Author:jilongliang
 *@Date  :2013-4-29
 *@Project:JavaSE
 *@Email:jilongliang@sina.com
 *@Description:tiff图片文件读取与分割
 */
public class ReadTifPage {
	//private static final String path = System.getProperty("user.dir") + "\\tif\\tif_images.tif";
	private static final String path = ReadTifPage.class.getClassLoader().getResource("tif/tif_images.tif").getPath();

	public static void main(String[] args) throws Exception {
		System.out.println(path);
		readTifPage();
		//readTifImages();
	}

	/**
	 * 单纯读tif文件的页数
	 */
	private static void readTifPage() {
		File file = null;
		Long tifPage;
		file = new File(path);
		if (file.isFile()) {
			FileSeekableStream fs = null;
			TIFFDecodeParam tifParam = new TIFFDecodeParam();
			try {
				fs = new FileSeekableStream(file);
				ImageDecoder dec = ImageCodec.createImageDecoder("tiff", fs, tifParam);
				tifPage = new Long(dec.getNumPages());
				System.out.println("这张图共有: " + tifPage+"页");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 分页读取，并获取出来
	 * @throws IOException
	 */
	private static void readTifImages() throws IOException {
		FileSeekableStream ss = new FileSeekableStream(path);
		TIFFDecodeParam param0 = null;
		TIFFEncodeParam param = new TIFFEncodeParam();
		JPEGEncodeParam param1 = new JPEGEncodeParam();
		ImageDecoder dec = ImageCodec.createImageDecoder("tiff", ss, param0);
		int count = dec.getNumPages();
		param.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
		param.setLittleEndian(false); // Intel
		System.out.println("这个Tif文件 有" + count + "十张图片");
		for (int i = 0; i <count; i++) {
			RenderedImage page = dec.decodeAsRenderedImage(i);
			File f = new File("./img_" + i + ".jpg");
			System.out.println("Saving " + f.getCanonicalPath());
			ParameterBlock pb = new ParameterBlock();
			
			pb.addSource(page);
			pb.add(f.toString());
			pb.add("JPEG");
			pb.add(param1);
			JAI.create("filestore", pb);
			
		    //JAI.create("filestore", page, "./Img_new" + i +".jpg", "JPEG", param1);
		}
	}
}
