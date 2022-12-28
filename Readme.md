In this exercise we've been requested to build 2 java classes, "ConcreteMember" and "GroupAdmin", and to code an observer design pattern.

in order to run the program open the project using Java suppotred IDE, and then navigate to src>test>java>Tests and run the desired test.

ConcreteMebmer:
a class in which we implement "Member" class from ex0. This class is responsible of observing and updating changes in UndoableStringBuilder(s). actually this is the observer.
ConcreteMebmer functions:
update - shallow copying an UndoableStringBuilder object.


GroupAdmin:
a class in which we implemet "Sender" class from ex0. This class is responsible of holding a list of Members. in this class we created functions to control and modify the list of the obserbed objects.
GroupAdmin functions:
getList:  return this list
getUndostring: return UndoableStringBuilder data
register:  adding an object to the observed list
unregister:  removing an object to the observed list
insert:  inserting a string with an offset to this.
append:  adding to the end of the UndoableStringBuilder the obj
delete:  deleting characters from the UndoableStringBuilder from start to end index
undo:  undoing the last change done
updateAll:  updating all the observed list
toString:  return UndoableStringBuilder


Part B:

in this part of the exercise we've been requested to use JVM Utilities in order to test our code.
In the tests class there is a test which called JVMTest. in this test we first printing JVM's process id, total memory allocated at the beginning of the program as well as the available number of cores.
afterward weve checked the object footprint (textual representation of the footprint) for both member and group.
we added the member to the group (list of observers) and the re-check the footprint.
