public class GPIOListener extends GpioPinListenerDigital{

  private int watchingValue;
  private GPIOReciever reciever;

  public GPIOListener(GPIOReciever rec, int value){
   reciever = rec;
   watchingValue = value;
  }

  @Override
  public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

    alertReciever();
      // display pin state on console
      System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
  }

  private void alertReciever(){
      reciever.recieveGPInput(watchingValue);
  }

}
