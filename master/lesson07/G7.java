package lesson07;

import GImage.GImage;

public class G7 {
	public static void main(String[] args)
	{
		 String fileName = "ImageFiles3/Label01.bmp";
	     GImage img= new GImage(fileName);

	     /**
	      * Get the width of the image-file.
	      */
	     int width = img.getWidth();
	     System.out.println("width="+width);

	     /**
	      * Get the height of the image-file.
	      */
	     int height = img.getHeight();
	     System.out.println("height="+height);

	     GImage img0= new GImage(height, width);
	     for(int i = 0; i < height; i++) {
	    	 for(int l = 0; l < width; l++) {
	    		 img0.pixel[i][l] = 255;
	    	 }
	     }

	     int x = -1;
	     int y = -1;
	     int Fx = -1;
	     int Fy = -1;
	     int count  = 0;
	     for(int i = 1; i < height-1; i++) {
	    	 for(int l = 1; l < width-1; l++) {
	    		 if(img.pixel[i][l] == 0) {
	    			 Fx = l;
	    			 Fy = i;
	    			 x = l;
	    			 y = i;
	    			 break;
	    		 }
	    	 }
	    	 if(x != -1) {
	    		 break;
	    	 }
	     }
	     int dec = 4;
	     boolean flag =true;
	     int[] rm = new int[8];
	     while(flag) {
	    	 rm[0] = img.pixel[y][x + 1];
	    	 rm[1] = img.pixel[y - 1][x + 1];
	    	 rm[2] = img.pixel[y - 1][x];
	    	 rm[3] = img.pixel[y - 1][x - 1];
	    	 rm[4] = img.pixel[y][x - 1];
	    	 rm[5] = img.pixel[y + 1][x - 1];
	    	 rm[6] = img.pixel[y + 1][x];
	    	 rm[7] = img.pixel[y + 1][x + 1];
	    	 switch(dec) {
	    	 	case 0:
	    	 		if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    	 			--x;
	    	 			dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		} else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:0");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 1:
	    	 		if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:1");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 2:
	    	 		if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:2");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 3:
	    	 		if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:3");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 4:
	    	 		if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else  {
	    	 			System.out.println("Error:4");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 5:
	    	 		if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:5");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 6:
	    	 		if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		}
	    	 		else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:6");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	case 7:
	    	 		if (rm[7] == 0) {
	    	 			++y;
	    	 			++x;
	    	 			dec = 5;
	    	 		} else if (rm[0] == 0) {
	    	 			++x;
	    	 			dec = 6;
	    	 		}
	    	 		else if (rm[1] == 0) {
	    	 			--y;
	    	 			++x;
	    	 			dec = 7;
	    	 		}
	    	 		else if (rm[2] == 0) {
	    	 			--y;
	    	 			dec = 0;
	    	 		}
	    	 		else if (rm[3] == 0) {
	    	 			--y;
	    		 		--x;
	    		 		dec = 1;
	    	 		}
	    	 		else if (rm[4] == 0) {
	    	 			--x;
	    	 			dec = 2;
	    	 		}
	    	 		else if (rm[5] == 0) {
	    	 			++y;
	    	 			--x;
	    	 			dec = 3;
	    	 		}
	    	 		else if (rm[6] == 0) {
	    	 			++y;
	    	 			dec = 4;
	    	 		}
	    	 		else {
	    	 			System.out.println("Error:7");
	    	 			flag = false;
	    	 		}
	    	 		break;
	    	 	default:
	    	 		System.out.println("Error");
	    	 	}
	    	 	img.pixel[y][x] = 100;


	    	 	if (y == Fy && x == Fx) {
	    	 		flag = false;
	    	 	}
	     }

	     for(int y2 = 0; y2 < height; ++y2) {
	    	 for(int x2 = 0; x2 < width; ++x2) {
	    		 if (img.pixel[y2][x2] == 100) {
	    			 img0.pixel[y2][x2] = 0;
	    		 } else {
	    			 img0.pixel[y2][x2] = 255;
	    	 	 }
	    	}
	 	 }



	     /**
	      *  Set the file name to "My_ImageG7".
	      */
	     String fileName01 = "bmp/My_ImageG7";

	     /**
	      *  Set the file type to "bmp".
	      */
	     String fileType01 = "bmp";

	     /**
	      * Output the image-file "My_Image01.bmp".
	      */
	     img0.output(fileName01,fileType01);

	     /**
	      * Set the file name to "My_Image01.bmp".
	      */
	     fileName01 +="." + fileType01;
	     System.out.println("Output file:"+fileName01);
	}
}
