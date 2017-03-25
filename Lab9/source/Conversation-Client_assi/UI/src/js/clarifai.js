/**
 * Created by putha on 9/14/2016.
 */
function getCredentials(cb) {
    var data = {
        'grant_type': 'client_credentials',
        'client_id': 'bDBNqQLKG-6ahr5WL_A_4Aw1B1YVHxLFer47823P',
        'client_secret': 'bpghTv11k83W2I7Z-JMaOgriMVeuGr564D2woAfG',
    };
    var url = 'https://api.clarifai.com/v1/token';

    return axios.post(url, data, {
        'transformRequest': [
            function() {
                return transformDataToParams(data);
            }
        ]
    }).then(function(r) {
        localStorage.setItem('accessToken', r.data.access_token);
        localStorage.setItem('tokenTimestamp', Math.floor(Date.now() / 1000));
        cb();
    }, function(err) {
        console.log(err);
    });
}

function transformDataToParams(data) {
    var str = [];
    for (var p in data) {
        if (data.hasOwnProperty(p) && data[p]) {
            if (typeof data[p] === 'string'){
                str.push(encodeURIComponent(p) + '=' + encodeURIComponent(data[p]));
            }
            if (typeof data[p] === 'object'){
                for (var i in data[p]) {
                    str.push(encodeURIComponent(p) + '=' + encodeURIComponent(data[p][i]));
                }
            }
        }
    }
    return str.join('&');
}

function postImage(imgurl) {
    var accessToken = localStorage.getItem('accessToken');
    var data = {
        'url': imgurl
    };
    var url = 'https://api.clarifai.com/v1/tag';
    return axios.post(url, data, {
        'headers': {
            'Authorization': 'Bearer ' + accessToken
        }
        /*'content-type': 'application/x-www-form-urlencoded'*/
    }).then(function(r) {
        parseResponse(r.data);
    }, function(err) {
        console.log('Sorry, something is wrong: ' + err);
    });
}

function parseResponse(resp) {
    var tags = [];
    if (resp.status_code === 'OK') {
        var results = resp.results;
        tags = results[0].result.tag.classes;
    } else {
        console.log('Sorry, something is wrong.');
    }

    document.getElementById('tags').innerHTML = tags.toString().replace(/,/g, ' <br>');
    return tags;
}

function run(imgurl) {
    if (Math.floor(Date.now() / 1000) - localStorage.getItem('tokenTimeStamp') > 86400
        || localStorage.getItem('accessToken') === null) {
        getCredentials(function() {
            postImage(imgurl);
        });
    } else {
        postImage(imgurl);
    }
}
