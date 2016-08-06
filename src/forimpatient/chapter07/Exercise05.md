_What is the meaning of_ `private[com] def giveRaise(rate: Double)`_? Is it useful?_

This means that the function can be only accessed inside com package. 
If the com package is the top one in project this is the same as 

`public def giveRaise(rate: Double)`

In other cases this can be useful to control a visibility in any way we need 