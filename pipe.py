'''A way of running commands to the os shell'''
import os

cmd = 'ls'
fp = os.popen(cmd)
# The return value is an object that behaves like an open file
print(fp.read())

stat = fp.close()
print(stat) #   The return value is the final status of the ❧s process; ◆♦♥❡ means that it ended normally (with no errors).
