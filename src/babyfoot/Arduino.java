
package babyfoot;

import java.util.Arrays;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;


public class Arduino implements SerialPortEventListener {
    static SerialPort serialPort;
    static String portName = "COM3"; // Remplacez "COM1" par le nom de votre port série
    static int baudRate = 57600; // Vitesse de transmission
    
    
    static double angle;
    static double rotation;
    static double distance;
    

  String buffer = "";

  @Override
  public void serialEvent(SerialPortEvent event) {
    if (event.isRXCHAR() && event.getEventValue() > 0) {
      try {
        String data = serialPort.readString(event.getEventValue());
        
        buffer += data;
        int index = buffer.lastIndexOf('\n');
        if (index >= 0) {
          String[] lines = buffer.substring(0, index).split("\r?\n");
          for (String line : lines) {
            try {
              
              String[] item = line.trim().split(" ");
              angle = Double.parseDouble(item[0]) * (Math.PI / 180);
              
                rotation = Double.parseDouble(item[item.length - 2]) * (Math.PI / 180);
              
              
                distance = (Double.parseDouble(item[item.length - 1]) - 80) * 1.16;
              
             /* System.out.print(angle);
              System.out.print("   ");
              System.out.print(rotation);
              System.out.print("   ");
              System.out.println(distance);*/
             //System.out.print(distance);
             //System.out.println(Arrays.toString(item));
              
              
              
            } catch (NumberFormatException ex) {
              System.out.println("Invalid float value: " + line);
            }
          }
          buffer = buffer.substring(index + 1);
        }
      } catch (SerialPortException ex) {
        System.out.println(ex);
      }
    }
  }

    
}
