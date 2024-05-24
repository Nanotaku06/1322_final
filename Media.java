
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Media {
    private String title;
    private String creator;

    public Media(){
        this.title ="Unknown Title";
        this.creator = "Unknown Creator";
    }

    public Media(String title, String creator){
        this.title =title;
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
