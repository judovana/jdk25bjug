# JEP 496

Demo where Receiver wants to start a symmetric communication with Sender.. Receiver starts, generates ML_KEM keypair and provides public key to the Sender. Sender then takes the public key, generates a secure key for symmetric communication, encapsulates it via the public key and provides this encapsulated blob to the Receiver to decapsulate.
Receiver then uses his private key to decapsulate the symmetric encapsulated key and prints it out.

`javac Receiver.java Sender.java`

`java Receiver`

in another terminal:

`java Sender`

then get back to the Receiver process and press a key to continue.
