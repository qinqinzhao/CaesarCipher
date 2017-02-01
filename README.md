The Caesar cipher is one of the oldest encryption techniques, and certainly one of the easiest to break.

The idea of a Caesar cipher is this: you encode a message by shifting each letter some number of places. Thus, if the shift is 2, then A becomes C, B becomes D, and so on. It is end around, so Y becomes A and Z becomes B. Like this:

<img src="https://github.com/qinqinzhao/CaesarCipher_cit590_upenn_wk12/blob/master/letter-shift.gif">

For an accurate Caesar cipher, we would discard all punctuation, and group the text into blocks of five letters. We won't do that here; we will retain all spacing and punctuation, and all capitalization. This will enable us to decipher messages to get exactly the original message.
