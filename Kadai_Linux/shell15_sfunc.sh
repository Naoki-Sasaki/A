sfunc1(){
    if[ $1 = "a" ]
        then ls -l -a
    else if [$1 = "r" ]
        then ls -l -r
    else if [ $1 = "ar" -o $1 = "ra" ]
        then ls -l -a -ra
    else ls -l
    fi
}