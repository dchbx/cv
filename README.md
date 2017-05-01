A Health Benefit Exchange Canonical Vocabulary Standard
==

This Canonical Vocabulary (CV) defines a reusable information model standard for Health Benefit Exchanges (HBX's). It specifies HBX data elements, defining their semantic meaning, data types and value ranges. For each HBX resource type, the CV enumerates triggers or events, as a basis for system services to notify one another when a business event has ocurred. The CV also defines a message schema for passing information between applications and organizations using RESTful Web services and popular messaging protocols.  

The HBX CV information model covers the following areas:

* Individual Market Qualified Health Plan (QHP) and assisted QHP benefit enrollment
* Small Business Health Insurance Options Program (SHOP) market benefit enrollment
* Qualified Life Events (QLE's) and Special Enrollment Periods (SEPs) for QHP and SHOP
* Household income and Advanced Premium Tax Credit (APTC) eligibility determinations
* Insurance issuers and plans
* Employer demographics
* Broker demographics
* Payments due, invoices and statements
* Premium payment advice/remittance

The HBX CV event model includes triggers for the following resource types:

* Application group
* Broker
* Carrier (issuer)
* Employee
* Employer
* Household
* Individual
* Policy
* Premium payment

The HBX CV message schema supports the following protcols:

* HTTP/SOAP
* JMS 
* AMQP

The CV is one of a larger set of components in an event-driven Service-oriented Architecture (SOA) designed to operate an HBX. 


### What is the HBX CV?
The CV is comprised of a set of XML schemas: a core schema (common.xsd) that defines base types, plus schema files organized by resource type, i.e. individual.xsd, employer.xsd, policy.xsd, etc.  For each resource type, the schema defines: 1) data elements, 2) request message, 3) response message, and 4) event message.

The CV is extensible, enabling tailoring to local HBX needs.  It also supports schema versioning for flexibility as requirements change.  The CV's URI pattern for enumerated terms and values demonstrates implementation of these and additional features.  

The following table explains the components of a typical HBX CV URI pattern: `urn:openhbx:terms:v1:resource#value` 

| Element    | Description   | Values |
| ---------- | ------------- | ------ |
| urn        |               | urn    |
| openhbx    | HBX authority for defined term. "openhbx" indicates global definition |
| terms      | Resource type | terms, requests, events |
| v1         | CV version that defines this resource   |
| resource   | Resource name |    |
| #value     | Resource value (hash character is used as separator) | 
 

For example, the URI: `urn:openhbx:terms:v1:us_state#Alabama` refers to a global term, as defined in CV version 1, for a resource named "us_state" with a value of "Alabama".  In other words, this is the HBX CV unique resource name for the state of Alabama.

This section serves as an introduction to CV schema features and concepts.  To access the CV schemas or review detailed documentation, see [ACApi Project](http://acapi.dchbx.org/docs/canonical_vocabulary/) 


### Why use the HBX CV?
Launching a successful state-based HBX is a formidable technical challenge. Behind the highly-publicized HBX closures in 2014, failed technology execution is a leading cause. This CV, along with tools and resources shared on this site, are intended to help integrate applications and provide technology solutions necessary to support the business operations of a well-functioning HBX.

The CV model embodies knowledge gained and lessions learned by DCHBX and project collaborators.  As an abstraction of HBX information content from commercial system formats and proprietary vocabularies, the CV offers multiple benefits:

* Introduces a standard specifically designed for HBX purposes, eliminating the cruft, compromises and limitations imposed as a result of adapting legacy technology
* Reduces the risk, time and cost necessary for a state to launch and operate an HBX
* Promotes a pluggable enterprise architecture capable of integrating many combinations of HBX commercial, custom and open source applications
* Enables multi-tenant functionality and peer-to-peer information communication between HBX's


### How to use the HBX CV?  

* Identify authority sources for each CV resource and event type
* For each authority information source, map attributes to CV elements
* For each authority event source, define message topic and/or HTTP endpoint and publish events via:
  * application trigger that sends notifications to event topic, or
  * polling program that periodically queries authority event source

### License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" href="http://purl.org/dc/dcmitype/Text" property="dct:title" rel="dct:type">Health Benefit Exchange Canonical Vocabulary</span> developed and managed by <a xmlns:cc="http://creativecommons.org/ns#" href="https://dchealthlink.com/" property="cc:attributionName" rel="cc:attributionURL">IdeaCrew, Inc.</a> and <a xmlns:cc="http://creativecommons.org/ns#" href="https://ideacrew.com/" property="cc:attributionName" rel="cc:attributionURL">HBX</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Attribution-ShareAlike 4.0 International License</a>.
