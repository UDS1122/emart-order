DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS Payment;

CREATE TABLE Orders (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  orderid VARCHAR(250) NOT NULL,
  userid VARCHAR(250) NOT NULL,
  productid VARCHAR(250) NOT NULL,
  quantity INT NOT NULL,
  amount decimal NOT NULL,
  orderdate Date NOT NULL,
  deliverydate Date NOT NULL
);

CREATE TABLE Payment (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  orderid VARCHAR(250) NOT NULL,
  amount decimal NOT NULL,
  status VARCHAR(20) NOT NULL,
  paymentdate Date NOT NULL,
  method VARCHAR(20) NOT NULL
);