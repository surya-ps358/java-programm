class AreaOfCircle{
    public static String getArea(double redius)
    {
        if(redius<=0){
            return ""+(-1);
        }
        else {
            final double pi=3.14;
            double areaOfCircle=pi*redius*redius;
            return ""+areaOfCircle;
        }
    }
}