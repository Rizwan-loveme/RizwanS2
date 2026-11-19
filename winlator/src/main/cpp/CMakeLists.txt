cmake_minimum_required(VERSION 3.22.1)

# Winlator was written for NDK 24 (clang 14). The project NDK is 29 (clang 21), where these C
# diagnostics are errors by default. Keep them as warnings so the original code still builds.
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -Wno-error=implicit-function-declaration -Wno-error=int-conversion -Wno-error=incompatible-function-pointer-types -Wno-error=incompatible-pointer-types -Wno-error=deprecated-non-prototype")

add_subdirectory(winlator)
add_subdirectory(vortekrenderer)
add_subdirectory(virglrenderer)
add_subdirectory(midihandler)
add_subdirectory(libadrenotools)
add_subdirectory(gladiorenderer)