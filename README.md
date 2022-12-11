# FixedRecordGenerator
A small library built in Java 11 and Maven to generate fixed length record strings. 
The actual use of this library is not recommended as it was done as an exercise on Java annotations and reflection.

### *Terminology: What is a "fixed record"?* 

A fixed record can be defined as a **fixed length string, which can be divided into fixed length 'fields'**. Therefore, the record's length is equal to the
sum of the fields' length.

Example: 

    "John$$$$Doe$$$$$23$"

This is a fixed record containing three fields: **name, lastname and age**.

**name** : A field of length 8. User's name can be placed in this field. To fill empty spaces, field is right padded with the '$' character.

**lastname** : A field of length 8. User's lastname can be placed in this field. To fill empty spaces, field is right padded with the '$' character.

**age** : A field of length 3. User's age (as a string) can be placed in this field. To fill empty spaces, field is right padded with the '$' character.