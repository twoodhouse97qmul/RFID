/*
Arnaud Is The Imposter Class.
This class is tasked with passing Wiegand values to the controller acting as the card reader.
The class is composed of:

1 Skeleton Key - this 'key' holds the valid wiegand code passed to it by the Duke (Stolen from an authenticated user or brute forced)
-only one key card value is held at once, any other methods such as fuzzing which require more are handled entirely byother classes.

GPIOutput - a module used to communicate with the Raspberry pi GPIO output pins.

--- Arnaud is named after Arnaud du Tilh -- https://en.wikipedia.org/wiki/Martin_Guerre
*/

public Arnaud {


  //Holds one key, should be updated to a valid wiegand code.
  private int [] skeletonKey;
  private GPIOutput chanel;
  private final int cardLength = 26;


private void updateKey(int [] value){
skeletonKey = value;
}

//Sends the skeleton key wiegand signal:
private void sendCode(){

  for (int i=cardLength; i>=0; i--) {
    if (getByte(value)==1) {
      chanel.send1();
    } else if ( bitRead(sendValue,x) == 0 ) {
      chanel.send0();
    }
    delay(2);//this is arduino.
  }


}

public void sendThisCode(int [] value){
  updateKey(value);
  sendCode();
}

private int getBit(int [] value, int index){
    if(value[index]==1){
      return 1;
    } else {
      return 0;
    }
}

}
