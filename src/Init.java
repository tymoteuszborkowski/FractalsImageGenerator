import fx.ImageDrawer;

import java.util.List;

public class Init {

    public static void main(String[] args) {

        Solution solution = new Solution();
        ImageDrawer imageDrawer = new ImageDrawer();

        solution.addCoordinates(1000000);

        List<Double> xCoordinates = solution.getxCoordinates();
        List<Double> yCoordinates = solution.getyCoordinates();

        for(int i = 0; i < xCoordinates.size(); i++){
            double x =  xCoordinates.get(i);
            double y = yCoordinates.get(i);

            imageDrawer.drawCoordinatesOnImage(x, y);

        }

        imageDrawer.saveImageToFile();
    }

}
