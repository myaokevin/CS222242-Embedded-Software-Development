/*
Problem :
We observe that the wheel chair could be moved at different surfaces, so we 
could change the force on wheel chair according to that to maintain the speed.
For eg: 
If we are ascending , we would need to increase the force on wheel chair in the direction of movement to maintain a speed.
If we are descending , we would need to increase the force on wheel chair opposite to the direction of movement to maintain a speed.
If we are moving on a level surface then, a constant force that produces the required speed is maintained,

In this scenario, we observe that there could be more additional states like moving in descending or ascending a stair case feature
added to the wheel chair. In such an addition of states , we need to easily add such feature/state without modifying much of the code.
Thus, open-closed (open for extension and closed for modification) principle needs to be followed 


Solution:
The state pattern defines an interface that specify a state-specific behaviour and have a class that implement the specific interface.
The state interface is implemented by the different states of the wheel chair object and state-specific behavior is implemented here 
within the class that wants to implement the state-specific behavior. In such case, any new state to be added could be done easily by 
creating a new class that implements the predifined interface and provide the state specific behavior within the class method. 

*/
class WheelChair{
  // methods and attributes available

}
interface MovingState{
  void changeForce();
}
class MovingStateContext{
  private MovingState currentMovingState;
  private WheelChair context;
  MovingStateContext(WheelChair context){
    this.context = context;
  }
  public void setCurrentMovingState(MovingState currentMovingState) {
    this.currentMovingState = currentMovingState;
  }
  void move(){
    if (currentMovingState!=null){
      currentMovingState.changeForce();
    }else{
      System.out.println("No change of force required!");
    }
  }
  public WheelChair getContext() {
      return this.context;
  }


}
class AscendOnLevelSurface implements MovingState{

  @Override
  public void changeForce() {
    //angles are detected and force needed are calculated prior
    System.out.println("Force increased as per angle of elevation");
    
  }

}
class DescendOnLevelSurface implements MovingState{

  @Override
  public void changeForce() {
    System.out.println("Force decreased as per angle of depression");
    
  }

}
public class StatePatternTest{
  public static void main(String[] args) {
    WheelChair chair = new WheelChair();// has arguments
    MovingStateContext context = new MovingStateContext(chair);

    context.setCurrentMovingState(new AscendOnLevelSurface());
    context.move();

    context.setCurrentMovingState(new DescendOnLevelSurface());
    context.move();

    
  }
}