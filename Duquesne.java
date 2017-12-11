public class Duquesne{

private Arnaud imposter;
private Hari skimmer;
private Fuzzer fuzzer;
private GPInput inputs;
private GPIOutput outputs;
private KeyRing keys;


 public Duquesne(){
   imposter = new Arnaud();
   skimmer = new Hari();

 }

 public static void main(String [] param){
   Duquesne duke = new Duquesne();
   duke.begin();

 }

 public void begin(){
    initialiseGPIOPins();
    initialiseArnaud();
    initialiseHari(inputs);
    enterSkimRepeatMode();
 }



 public void enterSkimRepeatMode(){
      skimmer.waitForCard();
 }

 public void recieveSkimmedCard(int [] cardValues){
  Arnaud.sendThisCode(cardValues);
  keys.addKey(cardValues);
 }

 public void enterTakeDownMode(){

 }



 private void initialiseHari(){

 }

 private void initialiseArnaud(){

 }

 private void initialiseGPIOPins(){
      inputs = new GPInput();
      outputs = new GPIOutput();
 }


}
