# Coverity Security Library
The Coverity Security Library (CSL) is a lightweight set of escaping routines for fixing cross-site scripting (XSS), SQL injection, and other security defects in Java web applications.  CSL is small, simple, and easy to use.

Here's why it's worth checking out:

* **It's secure:** We take the security of CSL seriously. Every change is carefully scrutinized through a process that includes manual code review, static analysis, fuzz testing, and unit testing.

* **It's convenient:** CSL contains escapers for XSS and SQL injection that are missing from standard libraries like Apache Commons and JEE.  We use fast, easy to invoke static methods with short, intuitive names.  We also provide hooks for Expression Language (EL) to make it easy to use within JSPs.

* **It's free:** CSL is distributed under a BSD-style license.  We would appreciate patches be sent back to us but it's not required.

Users of Coverity Security Advisor get remediation guidance based on escaping routines in CSL.  However, CSL is a standalone project with no dependencies on Security Advisor.


## Escape

The [Escape class](https://github.com/coverity/coverity-security-library/tree/master/coverity-escapers) contains several escapers for web content. These escaping functions help remedy common defects (mostly cross-site scripting) that occur when the data is inserted into HTML element, HTML attribute values, URI, JavaScript strings, SQL LIKE clauses, etc. More information are available in the [Escape directory](https://github.com/coverity/coverity-security-library/tree/master/coverity-escapers).

Before using any of these methods, you should understand the context (or nested contexts) in which the data is inserted. [Several examples](https://github.com/coverity/coverity-security-library/tree/master/coverity-escapers/samples) are available in the repository, and more will be available on [our blog](https://communities.coverity.com/blogs/security).

To include this library into your Maven project, add the following:

    <dependency>
        <groupId>com.coverity.security</groupId>
        <artifactId>coverity-escapers/artifactId>
        <version>1.0.0</version>
    </dependency>

Then you can use it directly in your JSPs:

    <%@ taglib uri="http://coverity.com/security" prefix="cov" %>
    <script>
        var x = '${cov:jsStringEscape(param.tainted)}';
    </script>

or in your Java programs:

    import com.coverity.security.Escape;
    // ...
    return "<div>" + Escape.html(request.getParameter("tainted")) + </div>;

To contact the SRL, please email us at <srl@coverity.com>. Fork away, we look forward to your pull requests!

# License
    Copyright (c) 2012, Coverity, Inc. 
    All rights reserved.

    Redistribution and use in source and binary forms, with or without modification, 
    are permitted provided that the following conditions are met:
    - Redistributions of source code must retain the above copyright notice, this 
    list of conditions and the following disclaimer.
    - Redistributions in binary form must reproduce the above copyright notice, this
    list of conditions and the following disclaimer in the documentation and/or other
    materials provided with the distribution.
    - Neither the name of Coverity, Inc. nor the names of its contributors may be used
    to endorse or promote products derived from this software without specific prior 
    written permission from Coverity, Inc.
    
    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
    EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND INFRINGEMENT ARE DISCLAIMED.
    IN NO EVENT SHALL THE COPYRIGHT HOLDER OR  CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
    INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
    PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
    WHETHER IN CONTRACT,  STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
    OF SUCH DAMAGE.