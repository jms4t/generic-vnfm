<img src="https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/openBaton.png" width="250"/>
  
  Copyright © 2015-2016 [Open Baton](http://openbaton.org). 
  Licensed under [Apache v2 License](http://www.apache.org/licenses/LICENSE-2.0).
  
[![Build Status](https://travis-ci.org/openbaton/generic-vnfm.svg?branch=develop)](https://travis-ci.org/openbaton/generic-vnfm)
  
# Generic VNF Manager

The Generic VNFManager is an implementation of a VNF Manager following the ETSI MANO specifications. t works as intermediate component between the NFVO and the VNFs, particularly the Virtual Machines on top of which the VNF software is installed. In order to complete the lifecycle of a VNF, it interoperates with the Element Management System (EMS) acting as an agent inside the VMs and executing scripts containeed in the vnf package.
This VNFM may be assigned the management of a single VNF instance, or the management of multiple VNF instances of the same type or of different types.

The Generic VNFManager is supposed to be used for any type of VNF that follows some convetions regarding:

* VMs deployment
* scriptIndex execution
* VMs termination

Please refer to [our documentation][generic-vnfm] for more details about this project.
 
## Technical Requirements

* openjdk 8+ or oracle JDK 8+
* a [NFVO](https://github.com/openbaton/NFVO) running instance
* The VMs need to have access to the openbaton repository (internet) thus to be able to dynamically download the [EMS](https://github.com/openbaton/ems)

## How to install Generic VNFM

It is strongly recommended to install it following the installation of the Open Baton platform that can be found [here](http://openbaton.github.io/documentation/nfvo-installation-deb/)

## How to use Generic VNFM

The way the Generic VNFM is installed changes the way how it is possible to start/stop it. If the Generic VNFM is installed using the debian package, then the commands available are:

```bash
sudo service openbaton-gvnfm start
```
or
```bash
sudo service openbaton-gvnfm stop
```

For further details please refer to [this documentation page](http://openbaton.github.io/documentation/nfvo-installation-deb/)

## Issue tracker

Issues and bug reports should be posted to the GitHub Issue Tracker of this project

# What is Open Baton?

Open Baton is an open source project providing a comprehensive implementation of the ETSI Management and Orchestration (MANO) specification and the TOSCA Standard.

Open Baton provides multiple mechanisms for interoperating with different VNFM vendor solutions. It has a modular architecture which can be easily extended for supporting additional use cases. 

It integrates with OpenStack as standard de-facto VIM implementation, and provides a driver mechanism for supporting additional VIM types. It supports Network Service management either using the provided Generic VNFM and Juju VNFM, or integrating additional specific VNFMs. It provides several mechanisms (REST or PUB/SUB) for interoperating with external VNFMs.

It can be combined with additional components (Monitoring, Fault Management, Autoscaling, and Network Slicing Engine) for building a unique MANO comprehensive solution.

## Source Code and documentation

The Source Code of the other Open Baton projects can be found [here][openbaton-github] and the documentation can be found [here][openbaton-doc] .

## News and Website

Check the [Open Baton Website][openbaton]
Follow us on Twitter @[openbaton][openbaton-twitter].

## Licensing and distribution
Copyright [2015-2016] Open Baton project

Licensed under the Apache License, Version 2.0 (the "License");

you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## Support
The Open Baton project provides community support through the Open Baton Public Mailing List and through StackOverflow using the tags openbaton.

## Supported by
  <img src="https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/fokus.png" width="250"/><img src="https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/tu.png" width="150"/>

[fokus-logo]: https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/fokus.png
[openbaton]: http://openbaton.org
[openbaton-doc]: http://openbaton.org/documentation
[openbaton-github]: http://github.org/openbaton
[openbaton-logo]: https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/openBaton.png
[openbaton-mail]: mailto:users@openbaton.org
[openbaton-twitter]: https://twitter.com/openbaton
[tub-logo]: https://raw.githubusercontent.com/openbaton/openbaton.github.io/master/images/tu.png
