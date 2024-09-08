The provided GET requests allow you to test the control of appliances by turning them on or off and 
retrieving their status using specific IDs for fans, lights, and air conditioners. 
POST requests are used to adjust the fan speed by specifying the appliance ID and the increment value.


GET requests

http://localhost:8080/appliances/test
http://localhost:8080/appliances/turnOff?id=fan2.
http://localhost:8080/appliances/turnOn?id=fan2
http://localhost:8080/appliances/turnOff?id=fan1.
http://localhost:8080/appliances/turnOff?id=light1
http://localhost:8080/appliances/turnOn?id=light1
http://localhost:8080/appliances/turnOff?id=ac1
http://localhost:8080/appliances/turnOn?id=ac1


POST requests

http://localhost:8080/appliances/increaseFanSpeed?id=fan2&increment=0
http://localhost:8080/appliances/increaseFanSpeed?id=fan2&increment=1
http://localhost:8080/appliances/increaseFanSpeed?id=fan2&increment=2
