# PEM 510+496

Similar demo to 496, with the difference of usage of JEP 510 to generate symmetric keys.

Now the Receiver is waiting to get a symmetric key and his first message as well.. provides (hopefully) quantum resistant public key.
Sender generates key for symmetric communication via JEP 510 mechanism and creates a message it encrypts using the symmetric cypher. Sender provides the encapsulated symmetric key and message.
Receiver now receives an encrypted message and to decrypt it it first needs to decapsulate the shared secret (symmetric key).

`javac Receiver.java Sender.java`

`java Receiver`

in another terminal:

`java Sender`

then get back to the Receiver process and press a key to continue.
