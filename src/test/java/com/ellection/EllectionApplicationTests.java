package com.ellection;

import com.ellection.models.Position;
import com.ellection.service.ImageService;
import com.ellection.service.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EllectionApplicationTests {

	@Autowired
	PositionService service;

	@Autowired
	ImageService imageService;

	@Test
	public void contextLoads() {
	}

	/*@Test
	public void testPositionService(){
		Position position = new Position("test");
	service.create("test");
	assertEquals("Should be equal", position.toString(), service.getPosByName("test").toString());

	}*/

	@Test
	public void testImageWork(){
		int width = 400;    //width of the image
		int height = 400;   //height of the image
		BufferedImage img = null;
		File f;

		try {
			f = new File(
					"/home/faos7/IdeaProjects/meaty-sweety/src/main/resources/image/cwqM2AeCygo.jpg");
			img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.err.println("error " + e.getMessage());
		}
		//String string = imageService.encodeToString(img);
		//BufferedImage image = imageService.decodeToImage(string);
		//boolean compare = imageService.compareImages(img, image);
		//assertEquals(image,img);
	}

}
