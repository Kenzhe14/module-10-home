class AudioSystem{
    public void TurnOn(){
        System.out.println("Audio system is turned on");
    }
    public void SetVolume(int level){
        System.out.println("Audio volume is set to "+ level);
    }
    public void TurnOff(){
        System.out.println("Audio system is turned off.");
    }
}

class TV{
    public void TurnOn(){
        System.out.println("TV is turned on.");
    }
    public void SetChannel(int channel){
        System.out.println("Tv channel is set to " + channel);
    }
    public void TurnOff(){
        System.out.println("TV is turned off.");
    }
}

class DVDPlayer{
    public void TurnOn(){
        System.out.println("DVDPlayer are turned on.");
    }
    public void Pause(){
        System.out.println("DVDPlayer are paused");
    }
    public void TurnOff(){
        System.out.println("DVDPlayer are turned off.");;
    }
}

class GameConsole{
    public void TurnOn(){
        System.out.println("GameConsole are turned on.");
    }
    public void GameOn(){
        System.out.println("GameConsole are game on.");;
    }
}

class HomeTheaterFacade{
    private AudioSystem audioSystem;
    private TV tv;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(AudioSystem audioSystem, TV tv, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.audioSystem = audioSystem;
        this.tv = tv;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void StartMovie(){
        System.out.println("Start Film");
        audioSystem.TurnOn();
        audioSystem.SetVolume(3);
        tv.TurnOn();
        tv.SetChannel(5);
        System.out.println("Film started");
    }
    public void TurnOff(){
        System.out.println("Turning off");
        audioSystem.TurnOff();
        tv.TurnOff();
    }
    public void Gameing(){
        tv.TurnOn();
        audioSystem.TurnOn();
        audioSystem.SetVolume(5);
        gameConsole.TurnOn();
        gameConsole.GameOn();
    }
}

public class Main3{
    public static void main(String[] args) {
        AudioSystem audioSystem = new AudioSystem();
        GameConsole gameConsole = new GameConsole();
        DVDPlayer dvdPlayer = new DVDPlayer();
        TV tv = new TV();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(audioSystem, tv, dvdPlayer, gameConsole);

        homeTheaterFacade.StartMovie();

        System.out.println();

        homeTheaterFacade.Gameing();

        System.out.println();

        homeTheaterFacade.Gameing();

    }
}