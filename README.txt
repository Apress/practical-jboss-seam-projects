This distribution contains the example code for Practical JBoss Seam
Projects, 1ed.  Each directory contains the code for the corresponding
chapter in the book.  Note that the code for the first chapter is
split into two directories.  The "intro-JavaEE" directory contains the 
vanilla Java EE version of the sample application, and the "intro-Seam"
directory contains the Seam version.

All sample code was tested using:

     - JBoss Seam 1.2.1 GA
     - JBoss Application Server 4.0.5 GA
          - Exception: The vanilla Java EE version of the sample in
            chapter 1 was tested in Glassfish 1.0.
     - Ant 1.6
     - Java 5.0 (1.5.0_07)

Each directory has the following structure:

     - src:    Contains all Java source code for the example.
     - web:    Contains all web pages and web resources (images, CSS, 
               Javascript) for the sample application.
     - config: Contains all configuration files (Java EE, Seam, 
               Hibernate, etc.).

The root directory contains an Ant build script, build.xml, and a 
build.properties file.  

To build and deploy the sample application, you will first need to setup a 
JBoss 4.0.5 environment with the EJB 3.0 embedded container.  See chapter
2 of the book for details. 

Once you've setup Java 5.0, Ant 1.6, JBoss AS 4.0.5, and downloaded Seam 1.2.1,
the steps to build and deploy each chapter's sample application are as follows:

     1) Edit the build.properties file and set the lib.dir and jboss.home
        properties.  The lib.dir property should refer to the directory
        in which JBoss Seam is placed (e.g., if Seam is in 
        /home/stuff/jboss-seam-1.2.1.GA, then lib.dir should be set 
        to "/home/stuff"). The jboss.home directory should refer to the 
        JBoss 4.0.5 installation directory (e.g., if the server is installed
        in /home/servers/jboss4.0.5.GA, then jboss.home should be set to
        "/home/servers/jboss4.0.5.GA").

     2) Run the "deploy-app" target in the Ant script.  This can be done
        from each chapter directory by running "ant deploy-app" or simply 
        "ant", from the command prompt.  The "deploy-app" target is the 
        default target in the build script.

You can exercise each sample application by navigating to the appropriate
home URL, as discussed in each chapter of the book.  The following list 
provides the default home web context for each sample application.  You
will need to preface each of these with the appropriate host/port for your
JBoss AS install (by default, this will be http://localhost:8080).

     intro-JavaEE:            /PracticalSeam-Intro-JavaEE/listGadgets.seam
     intro-Seam:              /PracticalSeam-Intro-Seam/listGadgets.seam
     configuration:           /PracticalSeam-Components/listGadgets.seam
     component-fundamentals:  /PracticalSeam-Components/listGadgets.seam
     conversations:           /PracticalSeam-Conversations/adminHome.seam
     pageflow:                /PracticalSeam-Pageflow/adminHome.seam
     security:                /PracticalSeam-Security/index.seam
     bpm:                     /PracticalSeam-BPM/index.seam
     rich-client:             /PracticalSeam-RichClient/index.seam