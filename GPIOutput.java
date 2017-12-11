public class GPIOutput{

  private int data0 = 8;
  private int data1 = 9;

public GPIOutput(){

}

//Sends 1 via wiegand signal by temporarily lowering voltage on data wire 1.
public void send1(){
  digitalWrite(data1, LOW);
  delayMicroseconds(34);
  digitalWrite(data1, HIGH);
}

//Sends 0 via wiegand signal by temporarily lowering voltage on data wire 0.
public void send0(){
  digitalWrite(data0, LOW);
  delayMicroseconds(34);
  digitalWrite(data0, HIGH);
}



}
