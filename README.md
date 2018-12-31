# moneytransferserviceA-B
Money Transfer Service. Service A sends money and Service B recive money. Java coding.

*** About:
- Service A send messages to service B.
- Service B is tracking a balance containing money in MySQL storage. It receive messages from service A and add to the balance accordingly.
- Service A and B are using HTTP Json messaging API.
- Service A is sending HTTP Json messages in decimal representation.
- "EUR" is only supported currency.
- Max ammount avaliable to send is +100000000 EUR and lowest is -100000000 EUR.
- Valid requests generate HTTP/200 requests.
- Invalid requests generate HTTP/400 responses.

*** Tools needed to run this service:
- IntelliJ IDE or Eclipse with Maven support.
- Installed Apache Active MQ.
- MySQL Server.

*** Steps to run the service:
- Open project in IntelliJ IDE or Esclipse as Maven project.
- Run the Main.
- Go to http://localhost:8161 and Login as username:"admin" and password:"admin".
- Create MySQL database called "money-transfer" with username:"root" and password:"root".
- Go to http://localhost:8080/swagger-ui.html and start sending money. :)
