if exist target\java rd /S /Q target\java
if exist target\java pause 0

mkdir target\java
if not exist target\java pause 0

pushd src

protoc --java_out=..\target\java Lobby.proto
if errorlevel 1 pause 0

protoc --java_out=..\target\java Room.proto
if errorlevel 1 pause 0

protoc --java_out=..\target\java Interop.proto
if errorlevel 1 pause 0

popd


if exist target\cpp rd /S /Q target\cpp
if exist target\cpp pause 0

mkdir target\cpp
if not exist target\cpp pause 0

pushd src

protoc --cpp_out=..\target\cpp Lobby.proto
if errorlevel 1 pause 0

protoc --cpp_out=..\target\cpp Room.proto
if errorlevel 1 pause 0

protoc --cpp_out=..\target\cpp Interop.proto
if errorlevel 1 pause 0

popd
