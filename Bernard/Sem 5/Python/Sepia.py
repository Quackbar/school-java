#Bernard Kintzing
#Sepai tone

import cImage as image

img = image.Image("luther.jpg")
newimg = image.EmptyImage(img.getWidth(), img.getHeight())
win = image.ImageWin()

for col in range(img.getWidth()):
    for row in range(img.getHeight()):
        p = img.getPixel(col, row)
        
        R = p.getRed()
        G = p.getGreen()
        B = p.getGreen()

        newR = (R * 0.393 + G * 0.769 + B * 0.189)
        newG = (R * 0.349 + G * 0.686 + B * 0.168)
        newB = (R * 0.272 + G * 0.534 + B * 0.131)

        newpixel = image.Pixel(int(newR), int(newG), int(newB))

        newimg.setPixel(col, row, newpixel)

newimg.draw(win)
win.exitonclick()
