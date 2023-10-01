var imgFeature = document.querySelector('.img-feature')
var listImage = document.querySelectorAll('.list-image img')
var btnPrev = document.querySelector('.prev')
var btnNext = document.querySelector('.next')

var currentIndex = 0;

function updateImageByIndex(index) {
    //remove active class
    document.querySelectorAll('.list-image div').forEach(item=>{
        item.classList.remove('active')
    })

    currentIndex = index
    imgFeature.src = listImage[index].getAttribute('src')
    // add active class clicked
    listImage[index].parentElement.classList.add('active')
}

listImage.forEach((imgElement, index) => {
    imgElement.addEventListener('click', e=>{
        imgFeature.style.opacity = '0'

        setTimeout(()=>{
            updateImageByIndex(index)
            imgFeature.style.opacity = '1'
        },300)

    })
})

btnPrev.addEventListener('click', e=>{
    if(currentIndex == 0){
        currentIndex = listImage.length-1
    }else{
        currentIndex--
    }
    imgFeature.style.animation = ''
    setTimeout(()=>{
        updateImageByIndex(currentIndex)
        imgFeature.style.animation = 'slideLeft 1s ease-in-out forwards'
    }, 200)
})

btnNext.addEventListener('click', e=>{
    if(currentIndex == (listImage.length -1)){
        currentIndex = 0
    }else {
        currentIndex ++
    }
    imgFeature.style.animation = ''
    setTimeout(()=>{
        updateImageByIndex(currentIndex)
        imgFeature.style.animation = 'slideRight 1s ease-in-out forwards'
    }, 200)
})

updateImageByIndex(0)
