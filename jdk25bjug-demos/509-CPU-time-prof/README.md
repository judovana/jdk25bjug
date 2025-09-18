# JEP 509
I made several attempts to get best possible difference in measurements, CpuVsWallThreadsDemo as is was the way to go as it showed 15% difference (cputimeBest.jfr file) in wallclock sampling and cputime. Feel look into other demos as well.

measure using:
`java -XX:StartFlightRecording=jdk.CPUTimeSample#enabled=true,filename=cputime.jfr CpuVsWallThreadsDemo`

use jmc to look into default method profiling - previously used approach

view cpu intensive method
`jfr view cpu-time-hot-methods cputimeBest.jfr`
