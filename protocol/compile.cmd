call wipe.cmd

mkdir target\java
mkdir target\cpp

if not exist target\java pause 0
if not exist target\cpp pause 0

pushd src
for %%i in (*.proto) do (
    protoc --java_out=..\target\java --cpp_out=..\target\cpp %%i
    if errorlevel 1 pause 0
)
popd
