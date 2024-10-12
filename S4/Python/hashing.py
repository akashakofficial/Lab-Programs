import hashlib
message="Akash".encode()
md5=hashlib.md5()
md5.update(message)
digest=md5.digest()
hex_digest=digest.hex()
print(hex_digest)