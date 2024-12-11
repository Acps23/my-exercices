/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function (cb) {
    const start = Date.now(); 
    cb();                     
    const end = Date.now(); 
    return end - start; 
};

/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function (value, delay, cb) {
    if (typeof cb !== 'function') {
        throw new Error("Callback must be a function");
    }
    if (typeof delay !== 'number' || delay < 0) {
        throw new Error("Delay must be a non-negative number");
    }
    setTimeout(() => {
        try {
            cb(null, value);
        } catch (err) {
            cb(err);
        }
    }, delay);
};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function (delay, cb) {
    if (typeof cb !== 'function') {
        throw new Error("Callback must be a function");
    }
    if (typeof delay !== 'number' || delay < 0) {
        throw new Error("Delay must be a non-negative number");
    }
    setTimeout(() => {
        try {
            cb(null);
        } catch (err) {
            cb(err);
        }
    }, delay);
};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function (delay) {
    return new Promise((resolve, reject) => {
        if (typeof delay !== 'number' || delay < 0) {
            reject(new Error("Delay must be a non-negative number"));
            return;
        }

        setTimeout(() => {
            resolve(`Resolved after ${delay}ms`);
        }, delay);
    });

};
