# Detect Suspicious Activity
Finding suspicious activity is the one step in fraud prevention. 
## Features
Given a live coming list of transactions to process, a suspicious activity detector explores the list and finds source or destinations which are suspicious.
This repository uses Java functional programming to implement this functionality. It contains a method which receives a list of transaction logs in a format 
{'from', 'to', 'amount'} and then find all source or destination users which has had transactions more than 'threshold'.  

# Setup/Requirements
* Java 11 or up
* Maven 3
