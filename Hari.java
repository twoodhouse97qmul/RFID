/*

Hari is a class dedicated to discretely collecting data for the rest of the system to use.
Hari is the spy for the system.

Wiegand codes sent by the card reader are sent to The Duke and stored for replay use later.

GPInput - an interface designed for collecting data from the raspberry pi GPIO connectors
whilst they are connected to the door reader.

named after Mata Hari.

*/

public class Hari implements GPIOReciever{


  private Duquesne theDuke;
  private GPInput inputController;
  private int [] currentInputCard;
  private int incomingByte = 0;
  private int bitsRecieved = 0;
  private int cardLength = 26;


public Hari(Duquesne owner, GPInput input){
  owner = theDuke;
  inputController = input;
  this.resetState();
}

public void waitForCard(){
    inputController.informMe(this);
}

private void startNewCard(){
  currentInputCard = new int [cardLength];
}

private void resetState(){
  bitsRecieved = 0;
  startNewCard();

}

public synchronized void recieveGPInput(int nextByte){
  boolean completed = this.processByte(nextByte); //wait for a boolean so that the other methods don't have to be synchronized.
  if(this.bitsRecieved == cardLength){
    recievedFullCard();
  }
}

public boolean processByte(int value){
 this.bitsRecieved++;
 boolean complete;
 if(value == 1){//49?
 return addByteToCard(1);
 }
  else{
    return addByteToCard(0);//48?
  }
}//end proccessByte

private boolean addByteToCard(int value){
   currentInputCard[bitsRecieved-1] = value;
   return true;
}

private void recievedFullCard(){
     theDuke.recieveSkimmedCard(currentInputCard);
     this.resetState();
}







/*
void reader1One(void) {
  reader1Count++;
  reader1 = reader1 << 1;
  reader1 |= 1;
}

void reader1Zero(void) {
  reader1Count++;
  reader1 = reader1 << 1;
}
*//*
void isr(int action) {
  if ( action == 1 ) { // Start
    /* Crazy People Timing and ISR -- Thanks Mike Cook!
      attachInterrupt(0, reader1Zero, FALLING);//DATA0 to pin 2
      attachInterrupt(1, reader1One, FALLING); //DATA1 to pin 3
      delay(10);
  } else { // Stop
      detachInterrupt(0);
      detachInterrupt(1);
  }

}

*/

/*
void printCardData(unsigned long data) {
    int serialNumber = (data >> 1) & 0x3fff;
    int siteCode = (data >> 17) & 0x3ff;
    Serial.print("\tH: ");
    Serial.print(data,HEX);
    Serial.print(" SC: ");
    Serial.print(siteCode);
    Serial.print(" C: ");
    Serial.println(serialNumber);
    Serial.print("\tB: ");
    Serial.println(data, BIN);
}
*//*
private void setup()
{

   /* This stuff is for the Door Sensor LED
  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);
  digitalWrite(LED, HIGH);
  pinMode(VX_NO1, INPUT); // Reader 1
  pinMode(VX_NO2, INPUT); // Reader 2
  // End Door Sensor Stuff

  /* Reader In -
  isr(0);
  isr(1);

   for(int i = 2; i<4; i++){
    pinMode(i, OUTPUT);
    digitalWrite(i, HIGH); // enable internal pull up causing a one
    digitalWrite(i, LOW); // disable internal pull up causing zero and thus an interrupt
    pinMode(i, INPUT);
    digitalWrite(i, HIGH); // enable internal pull up
  }
  delay(10);
  reader1 = 0;
  reader1Count = 0;

  //End Reader In

  pinMode(VX_D0,OUTPUT);
  digitalWrite(VX_D0, HIGH);

  pinMode(VX_D1,OUTPUT);
  digitalWrite(VX_D1, HIGH);
}

void loop() {
*/
  /* This stuff is for the Door Sensor LED *//*
  int reader1Status = digitalRead(VX_NO1);
  int reader2Status = digitalRead(VX_NO2);
  if ( reader1Status == HIGH || reader2Status == HIGH ) {
    Serial.println("---  D o o r  U n l o c k e d ---");
    digitalWrite(LED, LOW);
    delay(4000);
    digitalWrite(LED, HIGH);
   }
  // End Door Sensor Stuff

*/

/*
* Arduino Pinouts:
*        2 - ProxPoint Green (DATA 0)
*        3 - ProxPoint White (DATA 1)
*        8 - Output to VertX Data 0 (Green)
*        9 - Output to VertX Data 1 (White)
*        11 - VertX Strike Relay NO 1
*        12 - VertX Strike Relay NO 2
*        13 - LED
*        5V - To ProxPoint Red
*        GND - To ProxPoint Black
*        GND - To VertX Ground (Black)

* 26-Bit Wiegant Format:
* Bit 1 = Even Parity over Bits 2 - 13
* Bits 2 - 9 = Facility Code (0 to 255)
* Bits 10 - 25 = ID Number (0 to 65,535)
* Bits 26 Odd parity over bits 14 to 25

*/
