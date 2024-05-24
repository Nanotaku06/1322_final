public class Song extends Media implements IPlayable{
    private double duration;
    public Song(){
        super(); // using super here calls the default constructr from Media. Since I'm doing the same thing on both, it saves me coding space and tiem.
        duration = 1;
    }

    public Song(String title, String creator, double duration){
        super(title, creator); // calling the media super constructor to avoid redundancy. Doing the same thing here so no real downsides to it
        this.duration = duration;
    }

    @Override
    public void pauseMedia() {
        System.out.println("pausing...");
    }

    @Override
    public void playMedia() {
        System.out.println("playing...");
    }

    @Override
    public void stopMedia() {
        System.out.println("stopping...");
    }
}
