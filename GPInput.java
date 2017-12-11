import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class GPInput{

private GPIOReciever reciever;
boolean relaying;

  public GPInput(){
    this.relaying = false;
  }


  private void setUp(){

    final GpioController dataIn = GpioFactory.getInstance();

    final GpioPinDigitalInput dataIn0 = dataIn.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
    final GpioPinDigitalInput dataIn1 = dataIn.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);

    dataIn0.setShutdownOptions(true);
    dataIn1.setShutdownOptions(true);

    GPIOListener listener0 = new GPIOListener(reciever,0);
    GPIOListener listener1 = new GPIOListener(reciever,1);

    dataIn0.addListener(listener0);
    dataIn1.addListener(listener1);

  }

  public void informMe(GPIOReciever rec){
     this.reciever = rec;
     this.relaying = true;
     setUp();
  }
}
