C:
cd C:\Users\sproshchaev\.m2\repository\org\jasypt\jasypt\1.9.2
java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="remote" password=1234567890 algorithm=PBEWITHMD5ANDDES