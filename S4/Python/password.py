def check(password):
    rating=0
    length=len(password)
    if length>=8:
        rating=rating+1
    if length>=12:
        rating=rating+1
    if any (c.islower() for c in password):
        rating=rating+1
    if any (c.isupper() for c in password):
        rating=rating+1
    if any (c.isdigit() for c in password):
        rating=rating+1
    if any (c in "~!@#$%^&*_+-*/" for c in password):
        rating=rating+1
    return rating

password=input("Enter the Password : ")
rating=check(password)
print(rating)