import zipfile
ZIP_NAME = 'b2220356127'

files = [
    'Quiz1.java',
    ]

# comparision level
with zipfile.ZipFile(ZIP_NAME+'.zip', 'w', compression=zipfile.ZIP_DEFLATED, compresslevel=9) as zf:
    for file in files:
        zf.write(file)