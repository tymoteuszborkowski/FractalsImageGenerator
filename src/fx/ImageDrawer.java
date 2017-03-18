package fx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageDrawer {

    private final BufferedImage image = createEmptyImage();


    public void drawCoordinatesOnImage(double x, double y) {
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setStroke(new BasicStroke(0.001f));
        g2d.setPaint(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        Path2D path = new Path2D.Double();
        path.moveTo(x, y);
        path.lineTo(x, y);
        path.closePath();

        path.closePath();

        g2d.fill(path);
        g2d.draw(path);
    }



    private BufferedImage createEmptyImage() {
        BufferedImage br = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_RGB);
        setWhiteBackground(br);
        return br;

    }

    private void setWhiteBackground(BufferedImage br){
        for (int i = 0; i < br.getWidth(); i++) {
            for (int j = 0; j < br.getHeight(); j++) {
                br.setRGB(i, j, Color.WHITE.getRGB());
            }
        }
    }



    public void saveImageToFile() {
        File file = new File("image.png");

        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
