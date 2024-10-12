import requests
import tldextract

url = "https://www.google.com"
response = requests.get(url)
if response.status_code == 200:
    print(f"{url} is accessible on regular internet")
    ext = tldextract.extract(url)
    tld = ext.suffix
    if tld in ("onion", "bit", "i2p"):
        print(f"{url} is part of the Dark Web")
    else:
        print(f"{url} is not part of the Dark Web")
else:
    print(f"Failed to access {url}")
