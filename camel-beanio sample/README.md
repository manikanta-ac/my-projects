# camel-beanio Sample
Not in the project structure, but contails all the components that uses camel-beanio to unmarshal a message.

Referring to the example in http://camel.apache.org/beanio.html, we have a simple mapping file & a message with value spans more than one line.

Using camel-beanio, only the contents in first line in the message is being read a one record into the exchange's body at one iteration.

The next line is being treated as new record and unmarshalling breaks as BeanIOErrorHandler warns it as invalid record.

We had to add a camel processor to remove the line breaks in the message before unmarshalling to read complete multi-line message, which may not be the best solution in all real time cases. 


Realted to: https://issues.apache.org/jira/browse/CAMEL-11479

Similar to: https://stackoverflow.com/questions/25585731/apache-camel-parsing-csv-files-with-multilines-values
