long valor1, valor2, valor3, valor4;


void setup() {

    Serial.begin(9600);

}

void loop() {

  valor1 = analogRead(A0);
  valor2 = analogRead(A1);
  valor3 = analogRead(A2);
  valor4 = analogRead(A3);



  String sl = String(((6.0/1705.0)*valor1)+4.3);
  String sw = String(((2.4/1023.0)*valor2)+2.0);
  String pl = String(((59.0/10230.0)*valor3)+1.0);
  String pw = String(((4.0/1705.0)*valor4)+0.1);
 // Serial.println(String(sw) +" " + String (valor));
 
  Serial.println("{\"sl\":" + sl + ", \"sw\":" + sw +", \"pl\":" + pl + ", \"pw\":" + pw + "}");
 
  delay(3000);
}
