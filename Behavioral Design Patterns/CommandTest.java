/*
Problem :
The voice recognition system that commands the motion of the wheel chair would need to be implemented.
Here, it would be needed to perform different operations based on different voice commands, thus a need to decide which command to perform needs to be determined at real time.
The commands that could operate the wheel chair could be : 
    1. Move Forward
    2. Turn Around
    3. Turn Right
    4. Turn Left
    5. Stop


*/
/*
Solution:
The command design pattern could be used to solve this problem.
The implementation of a command interface which could be implemented in each seperated concrete command classes , so that the Invoker(Command Executer) is not directly involved 
with the reciever(). Here, we need not keep track of changes , but if a need appears we could keep track of the movement of the wheel chair ( to determine the movement done based on voice commands) , so that a real time movement of 
the wheel chair could be watched for selected patients. 
We do not undo commands in this system though that is possible feature implemented efficiently using a command pattern.

*/

//Command
interface Command{
    void execute();
}

//Concrete Commands
class MoveForwardCommand implements Command{
    private WheelChair chair;
    public MoveForwardCommand(WheelChair chair) {
        this.chair = chair;
    }
    @Override
    public void execute() {
        System.out.println(".................................");
        System.out.println("The System is moving forwards");
        chair.action(this);
        
    }

}
class TurnAroundCommand implements Command{
    private WheelChair chair;
    public TurnAroundCommand(WheelChair chair) {
        this.chair = chair;
    }
    @Override
    public void execute() {
        //  This could be implemented using 2 turn right/left commands at a slow pace.
        System.out.println(".................................");
        System.out.println("The System is turned around");
        chair.action(this);
        
    }
    
}
class TurnRightCommand implements Command{
    private WheelChair chair;
    public TurnRightCommand(WheelChair chair) {
        this.chair = chair;
    }
    @Override
    public void execute() {
        System.out.println(".................................");
        System.out.println("The System is turned right");
        chair.action(this);
        
    }
    
}
class TurnLeftCommand implements Command{
    private WheelChair chair;
    public TurnLeftCommand(WheelChair chair) {
        this.chair = chair;
    }
    @Override
    public void execute() {
        System.out.println(".................................");
        System.out.println("The System is turned left");
        chair.action(this);
    }
    
}

class StopCommand implements Command{
    private WheelChair chair;
    public StopCommand(WheelChair chair) {
        this.chair = chair;
    }
    @Override
    public void execute() {
        System.out.println(".................................");
        System.out.println("The System is stopped");
        chair.action(this);
        
    }
    
}
// Invoker
class VoiceCommander{
    private WheelChair chair;
    public VoiceCommander(WheelChair chair) {
        this.chair = chair;
    }
    VoiceCommander(){}
    public void operate(Command command){
        command.execute();
    }
}

//Reciever
class WheelChair{
    private int id;
    WheelChair(int id ){
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void action(Command command){
        System.out.println(command.getClass().getSimpleName()+"'s action taking place in wheelchair");
        System.out.println(".................................");
    }
}

public class CommandTest{
    public static void main(String[] args) {
        WheelChair wc  =  new  WheelChair(1);
        VoiceCommander vc = new VoiceCommander(wc);
        
        MoveForwardCommand mvfCommand = new MoveForwardCommand(wc);
        vc.operate(mvfCommand);
        TurnAroundCommand taCommand = new TurnAroundCommand(wc);
        vc.operate(taCommand);
        TurnRightCommand trCommand = new TurnRightCommand(wc);
        vc.operate(trCommand);
        TurnLeftCommand tlCommand = new TurnLeftCommand(wc);
        vc.operate(tlCommand);
        
    }
}