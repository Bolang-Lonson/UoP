'''The module dbm provides an interface for creating and updating database files. As an
example, I’ll create a database that contains captions for image files.'''

import dbm

db = dbm.open('captions', 'c')
# The mode 'c' means that the database should be created if it doesn’t already exist
db['saadiq.png'] = 'Photo of Saadiq'
db['saadiq_age'] = '22'
db['saadiq_name'] = 'Bolang-Lonson Beinyoh Nfi'

print(db['saadiq.png']) #   b'Photo of Saadiq'
# The result is a bytes object, which is why it begins with b.
# If you make another assignment to an existing key, dbm replaces the old value:
db['saadiq.png'] = 'Drawing of Saadiq'
print(db['saadiq.png'])

for key in db.keys():
    print(key, db[key])

db.close()
'''A limitation of dbm is that the keys and values have to be strings or bytes. If you try to use
any other type, you get an error.
The pickle module can help. It translates almost any type of object into a string suitable
for storage in a database, and then translates strings back into objects.'''

import pickle
t1 = [1, 2, 3]
s = pickle.dumps(t1)
print(s)
t2 = pickle.loads(s)
print(t2)
print(t1 == t2)
print(t1 is t2)