The SRF format is just a standard text file. The extention does not matter as the program calls it with the file extention.
First line contains the default words which are used when demo mode is enabled.
The last word is not used normally but instead the format for all overflowed words. If you do not want an overflow you can leave it as " " or "".
The overflowed words will be inserted into the payload at $Overflow. No extra formatting is done.
Upon pressing "GO!" these words are used instead of words from the input box.

$W{X} is the "X"th word, counting from zero. The same word can be used in more than one location.
It's up to the creator of the format to make sure that default words work along with the format as well as X is incremented by only 1.
Inproper formatting can cause $W{X} to not be replaced with words and other small bugs.